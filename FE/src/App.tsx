import { Routes, Route } from "react-router-dom";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Dashboard from "./pages/Dashboard";
import createStore from 'react-auth-kit/createStore';
import AuthProvider from "react-auth-kit/AuthProvider";
import AuthOutlet from "@auth-kit/react-router/AuthOutlet";

function App() {
  const store = createStore({
    authName:'_auth',
    authType:'cookie',
    cookieDomain: window.location.hostname,
    cookieSecure: false,
  });

  return (
    <AuthProvider store={store}>
      <Routes>
        <Route path="/login" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
        <Route element={<AuthOutlet fallbackPath='/login' />}>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/" element={<>hello</>} />
        </Route>
      </Routes>
    </AuthProvider>
  )
}



export default App
