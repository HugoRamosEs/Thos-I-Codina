<?php



/**
 * ZonaRepository
 *
 * This class was generated by the Doctrine ORM. Add your own custom
 * repository methods below.
 */
class ZonaRepository extends Doctrine\ORM\EntityRepository {
    public function informacio() {
        $dql = "SELECT z FROM Zona z";
        $query = $this->_em->createQuery($dql);
        return $query->getResult();
    }
}
