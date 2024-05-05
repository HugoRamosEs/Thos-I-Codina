import styles from "./Header.module.scss"
import MainMenu from "../MainMenu/MainMenu";

function Header() {
  return (
    <>
      <div className={styles.header}>
        <h1>SoftGPL</h1>
        <MainMenu></MainMenu>
        <input type="search" id="search" name="search" placeholder="Search"></input>
      </div>
    </>
  )
}

export default Header