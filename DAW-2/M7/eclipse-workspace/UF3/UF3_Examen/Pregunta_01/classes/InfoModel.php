<?php
namespace curriculum;

class InfoModel extends Model {
    
    public function __construct() {
        parent::__constrcut();
    }
    
    public function getByUser(Usuari $oUsuari) {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_info WHERE usuari_id = ?;");
        $stmt->bind_param("i", $oUsuari->getId());
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Info();
                $oItem->setCodi($item['codi']);
                $oItem->setDada($item['dada']);
                $oItem->setFa($item['fa']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;        
    }
    
    public function getAll() {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_info WHERE usuari_id = ?;");
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Info();
                $oItem->setCodi($item['codi']);
                $oItem->setDada($item['dada']);
                $oItem->setFa($item['fa']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;
    }
}

