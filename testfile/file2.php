<?php
class UserController {
  function __construct(SQLConnector $conn){
    $this->connection = $conn;
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