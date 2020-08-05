#include <ESP8266WiFi.h>

#define NAME "JioFi_24540AD"
#define PASS "sravan1290"

const char* host = "192.168.1.102";

WiFiClient client;

void setup() {
  Serial.begin(115200);
  Serial.println();

  /* Set Client up as station */
  WiFi.mode(WIFI_STA);

  WiFi.begin(NAME, PASS);

  /* Connect to the network */
  Serial.print("Connecting");
  while(WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println();

  Serial.print("Connected, IP address: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  if (client.connect(host, 9090))
  {
    Serial.print("Connected to: ");
    Serial.println(host);

    /* Send "connected" to the server so it knows we are ready for data */
    client.println("deviceconnected"); //USE client.println()!!
    Serial.println("Host message: \n");

    /* Wait for data for 5 seconds at most before timing out */
    unsigned long timeout = millis();
    while(client.available() == 0)
    {
      if(millis() - timeout > 5000)
      {
        Serial.println("Timeout to server!");
        break;
      }
    }

    /* Read in the data in the stream */
    while(client.available() > 0)
    {
      Serial.println(client.readStringUntil('\n'));
    }
    client.stop();
  }
  else
  {
    client.stop();
  }
  delay(5000);
}
