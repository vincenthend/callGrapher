<?php
class UserController {
  function __construct(){
    $this->connection = new SQLConnector();
  }
  function showProfile($username){
      $a = 1;
      $dm = null;
      if($a == 1){
          $dm = new DataModel();
      }
    $userdata = $dm->getUserData($username, $this->connection);
    showview('template.php', $userdata);
  }
}
?>