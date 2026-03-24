FROM jenkins/jenkins:lts                                                                                                       

                                                                                                                               

  USER root                                                                                                                      

   

  # Install Java 21 and Maven                                                                                                    
RUN apt-get update && \
  apt-get install -y openjdk-21-jdk maven && \
  apt-get clean

 

  # Set Java environment

  ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64

  ENV PATH=$JAVA_HOME/bin:$PATH                                                                                                  

   

  # Set Maven environment                                                                                                        

  ENV MAVEN_HOME=/usr/share/maven                                                                                              

  ENV PATH=$MAVEN_HOME/bin:$PATH                                                                                                 

                                                                                                                                 

  USER jenkins