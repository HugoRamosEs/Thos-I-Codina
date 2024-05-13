import styles from './MainVideoChat.module.scss';
import Video from '../Video/Video';
import Chat from '../Chat/Chat';

function MainVideoChat() {
  return (
    <>
        <div className={styles.main_videochat}>
            <Chat></Chat>
            <Video></Video>
        </div>
    </>
  )
}

export default MainVideoChat