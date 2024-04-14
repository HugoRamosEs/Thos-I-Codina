import styles from "./Error404.module.scss";

function Error404() {
  return (
    <div className={styles.main_error404}>
      <h2>Error 404</h2>
      <span>Page not found</span>
    </div>
  )
}

export default Error404