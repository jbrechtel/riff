FROM    ubuntu
MAINTAINER James Brechtel "jbrechtel@gmail.com"

RUN rm /etc/apt/sources.list
RUN echo deb http://archive.ubuntu.com/ubuntu precise main universe multiverse > /etc/apt/sources.list

RUN apt-get update
RUN apt-get install vim supervisor openjdk-7-jre-headless wget -y

RUN mkdir -p /home/riff
RUN useradd -d /home/riff riff

ADD riff-web.jar /home/riff/riff-web.jar
ADD supervisord.conf /etc/supervisord.conf

RUN chown -R riff /home/riff

EXPOSE 8000
EXPOSE 9001

CMD ["/usr/bin/supervisord", "-c", "/etc/supervisord.conf"]
