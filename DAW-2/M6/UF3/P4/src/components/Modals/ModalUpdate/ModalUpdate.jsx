import { Modal } from 'react-bootstrap';

function ModalUpdate({ showUpdateModal, setShowUpdateModal, handleUpdate }) {
    return (
    <Modal show={showUpdateModal} onHide={() => setShowUpdateModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>Confirm Update</Modal.Title>
        </Modal.Header>
        <Modal.Body>Are you sure you want to update this note?</Modal.Body>
        <Modal.Footer className="d-flex justify-content-center">
          <button className="btn btn-secondary rounded-0" onClick={() => setShowUpdateModal(false)}>Cancel</button>
          <button className="btn btn-primary rounded-0" onClick={handleUpdate}>Update</button>
        </Modal.Footer>
    </Modal>
    );
}

export default ModalUpdate