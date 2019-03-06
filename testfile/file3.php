<?php
    class SQLConnector{
        function runQuery($query){
            $con=mysqli_connect("localhost","my_user","my_password","my_db");
            if (mysqli_connect_errno()) {
                echo "Failed to connect to MySQL: " . mysqli_connect_error();
            } else {
                // Perform queries
                $userdata = mysqli_fetch_assoc(mysqli_query($con,$query)->fetch_assoc());
                mysqli_close($con);
            }

            return $userdata;
        }
    }
?>