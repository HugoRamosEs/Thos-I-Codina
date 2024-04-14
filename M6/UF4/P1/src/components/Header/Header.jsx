import MainMenu from '../MainMenu/MainMenu'
import styles from './Header.module.scss'

function Header() {
  return (
    <>
      <div className={styles.header}>
        <h1>SoftGPL</h1>
        <MainMenu></MainMenu>
        <input type='search' name='search' id='search' placeholder='Search'></input>
      </div>
    </>
  )
}

export default Header