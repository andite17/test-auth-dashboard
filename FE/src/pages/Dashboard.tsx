import { Button } from '@mui/material'
import axios from 'axios'
import { useState } from 'react'
import useAuthUser from 'react-auth-kit/hooks/useAuthUser'
import useSignOut from 'react-auth-kit/hooks/useSignOut'
import { useNavigate } from 'react-router-dom'

const Dashboard = () => {
    const signOut = useSignOut()
    const navigate = useNavigate()
    const authData = useAuthUser()
    const [user, setUser] = useState("")
    
    const logout = () => {
        console.log("logout")
        signOut()
        navigate("/login")
    }
    const getData = async(auth: any) => {
        const {data} = await axios.get('http://localhost:8080/user/me', {
            headers: {
              'Authorization': `Bearer ${auth.token}`
            }
        })
        
        setUser(data.fullName)
    }
    getData(authData)
    
    return (
        <div>
            <div>Dashboard</div>
            <div>Welcome {user}</div>
            <Button onClick={() => logout()}>Logout</Button>
        </div>
    )
}

export default Dashboard