<?php
class DataModel {
  public $connection;

  function getUserData($username, $connection){
      $userdata = $connection->runQuery("SELECT * FROM User WHERE username='".$username."'");

      return $userdata;
  }
}
?>