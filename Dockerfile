FROM rsunix/yourkit-openjdk17

ADD target/WishTheSpire.jar WishTheSpire.jar
ENTRYPOINT ["java", "-jar", "WishTheSpire.jar"]
EXPOSE 8080