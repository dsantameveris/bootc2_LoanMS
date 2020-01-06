#This is the base.
FROM java:8

#This is the port.
EXPOSE 8016:8016

#No idea
ADD /target/LoanJar.jar LoanJar.jar

#No idea
ENTRYPOINT ["java", "-jar", "LoanJar.jar"]