import styles from "./MainContent.module.scss"

import { Link } from "react-router-dom";

function MainContent() {
  return (
    <>
      <div className={styles.main_content}>
        <h2>Home</h2>
        <h3>Welcome to the home page</h3>
        <div>
          <p>Added a new section to the page that allows you to chat, share screen and do videocall with filters!</p>
          <Link to={"/videochat"}>Take a look!</Link>
        </div>
      </div>
    </>
  )
}

export default MainContent