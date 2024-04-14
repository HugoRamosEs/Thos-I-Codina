import styles from './Profile.module.scss'
import { useContext } from 'react'
import LoginContext from '../../context/LoginContext'

function Profile() {
  const { login } = useContext(LoginContext);

  return (
    <div className={styles.main_profile}>
      <h2>User Profile</h2>
      <table>
        <tbody>
          <tr>
            <td>Id:</td>
            <td>{login.id}</td>
          </tr>
          <tr>
            <td>Name:</td>
            <td>{login.name}</td>
          </tr>
          <tr>
            <td>Surname:</td>
            <td>{login.surname}</td>
          </tr>
          <tr>
            <td>Email:</td>
            <td>{login.email}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default Profile