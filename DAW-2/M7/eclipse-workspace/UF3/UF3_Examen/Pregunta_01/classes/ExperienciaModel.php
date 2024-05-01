<?php
namespace curriculum;

class ExperienciaModel extends Model {
    
    public function __construct() {
        parent::__constrcut();
    }
    
    public function getByUser(Usuari $oUsuari) {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_experiencia WHERE usuari_id = ?;");
        $stmt->bind_param("i", $oUsuari->getId());
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Experiencia();
                $oItem->setPeriode($item['periode']);
                $oItem->setEmpresa($item['empresa']);
                $oItem->setCarrec($item['carrec']);
                $oItem->setDescripcio($item['descripcio']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;        
    }
    
    public function getAll() {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_experiencia WHERE usuari_id = ?;");
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Experiencia();
                $oItem->setPeriode($item['periode']);
                $oItem->setEmpresa($item['empresa']);
                $oItem->setCarrec($item['carrec']);
                $oItem->setDescripcio($item['descripcio']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;
    }
}

