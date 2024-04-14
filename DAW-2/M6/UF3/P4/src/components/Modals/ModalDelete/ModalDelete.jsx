import { Modal } from 'react-bootstrap';

function ModalDelete({ showDeleteModal, setShowDeleteModal, handleDelete }) {
    return (
      <Modal show={showDeleteModal} onHide={() => setShowDeleteModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>Confirm Delete</Modal.Title>
        </Modal.Header>
        <Modal.Body>Are you sure you want to delete this note?</Modal.Body>
        <Modal.Footer className="d-flex justify-content-center">
          <button className="btn btn-secondary rounded-0" onClick={() => setShowDeleteModal(false)}>Cancel</button>
          <button className="btn btn-danger rounded-0" onClick={handleDelete}>Delete</button>
        </Modal.Footer>
      </Modal>
    );
}

export default ModalDelete