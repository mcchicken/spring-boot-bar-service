#Untappd client_id and client_secret must be passed to the command
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD checkin-service-1.0-SNAPSHOT.jar checkin-service-1.0.jar
ENTRYPOINT ["java" \
    ,"-jar" \
    ,"/checkin-service-1.0.jar" \
    ,"--client_id=D5F54706652DD942DCF1C6AC855B7C22CF810FAE" \
    ,"--client_secret=6052C04CB127292C60BF5EE38D91C59E888F9EBA"]