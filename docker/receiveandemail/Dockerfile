# basic python image
FROM python:3.7

# install pika to access rabbitmq
RUN pip install pika

# Without this setting, Python never prints anything out.
ENV PYTHONUNBUFFERED=1

# declare the source directory
WORKDIR /usr/src/app/receiveandemail

# copy the file
COPY receiveandemail.py .

# start command
CMD [ "python", "receiveandemail.py" ]