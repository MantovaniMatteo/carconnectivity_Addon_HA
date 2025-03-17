{
    "carConnectivity": {
        "log_level": "{{ .log_level }}",
        "connectors": [
            {{- $first := true }}
            {{- if .connector_username_seatcupra }}
            {{- if not $first }},{{ end }}
            {{- $first = false }}
            {
                "type": "seatcupra",
                "config": {
                    "brand": "{{ .connector_brand_seatcupra }}",
                    "username": "{{ .connector_username_seatcupra }}",
                    "password": "{{ .connector_password_seatcupra }}",
                    "interval": {{ .connector_interval_seatcupra }},
                    "spin": "{{ .connector_spin_seatcupra }}",
                    "api_log_level": "{{ .api_log_level }}"
                }
            }
            {{- end }}
        ],
        "plugins": [
            {
                "type": "mqtt",
                "config": {
                    "username": "{{ .mqtt_username }}",
                    "password": "{{ .mqtt_password }}",
                    "broker": "{{ .mqtt_broker }}",
                    "log_level": "{{ .log_level }}"
                }
            },
            {
                "type": "webui",
                "config": {
                    "username": "{{ .connector_username_webui }}", 
                    "password": "{{ .connector_password_webui }}",
                    "log_level": "{{ .log_level }}"
                }
            },
            {
                "type": "mqtt_homeassistant",
                "config": {
                    "log_level": "{{ .log_level }}"
                }
            }
        ]
    }
}
