import styles from "./Header.module.scss";

function Header() {
  return (
    <div id="header" className={styles.header}>
      <div className={styles.logo}>
        <img src="logo.png" alt="logo.png"></img>
        <h1>Soft<span>GPL</span></h1>
      </div>
      <nav className={styles.navbar_header}>
        <ul>
          <li><a href="">Blog</a></li>
          <li><a href="">Fòrum</a></li>
          <li><a href="">Clients</a></li>
        </ul>
      </nav>
    </div>
  )
}

export default Header