<?php
    class SQLConnector{
        function runQuery($query){
            global $PMF_LANG, $plr;

            $this->_config  = $config;
            $this->pmf_lang = $PMF_LANG;
            $this->plr      = $plr;

            if ($this->_config->get('security.permLevel') == 'medium') {
                $this->groupSupport = true;
            }
        }
    }
?>