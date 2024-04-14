import { Modal } from 'react-bootstrap';

function ModalMessage({ showMessageModal, setShowMessageModal, message }) {
    return (
      <Modal show={showMessageModal} onHide={() => setShowMessageModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>Information Message</Modal.Title>
        </Modal.Header>
        <Modal.Body>{message}</Modal.Body>
        <Modal.Footer className="d-flex justify-content-center">
          <button className="btn btn-info rounded-0 px-5" onClick={() => setShowMessageModal(false)}>Ok</button>
        </Modal.Footer>
      </Modal>
    );
}

export default ModalMessage