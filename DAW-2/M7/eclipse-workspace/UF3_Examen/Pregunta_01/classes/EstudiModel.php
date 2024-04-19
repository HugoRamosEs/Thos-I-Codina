<?php
namespace curriculum;

class EstudiModel extends Model {
    
    public function __construct() {
        parent::__constrcut();
    }
    
    public function getByUser(Usuari $oUsuari) {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_estudis WHERE usuari_id = ?;");
        $stmt->bind_param("i", $oUsuari->getId());
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Estudi();
                $oItem->setAny($item['any']);
                $oItem->setTitol($item['titol']);
                $oItem->setDescripcio($item['descripcio']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;        
    }
    
    public function getAll() {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_estudis;");
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Estudi();
                $oItem->setAny($item['any']);
                $oItem->setTitol($item['titol']);
                $oItem->setDescripcio($item['descripcio']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;
    }
}

