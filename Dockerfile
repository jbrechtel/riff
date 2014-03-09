FROM ubuntu
MAINTAINER James Brechtel "jbrechtel@gmail.com"

RUN rm /etc/apt/sources.list
RUN echo deb http://archive.ubuntu.com/ubuntu precise main universe multiverse > /etc/apt/sources.list

RUN apt-get update
RUN apt-get install vim supervisor openjdk-7-jre-headless wget -y

RUN mkdir -p /home/riff
RUN useradd -d /home/riff riff

ADD config/supervisord.conf /etc/supervisord.conf

RUN chown -R riff /home/riff

ENV foo bar

CMD ["/usr/bin/supervisord", "-c", "/etc/supervisord.conf"]

ADD target/riff-web.jar /home/riff/riff-web.jar