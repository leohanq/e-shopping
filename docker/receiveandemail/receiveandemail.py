import pika
import smtplib
import json
from email.mime.text import MIMEText

class MessageConsumer:
    def __init__(self):
        self.connection_parameters = pika.ConnectionParameters('rabbitmq')
        self.connection = pika.BlockingConnection(self.connection_parameters)
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='e_notification-queue', durable=True)
        self.channel.basic_consume(queue='e_notification-queue', auto_ack=True,
                                   on_message_callback=self.on_message_received)

    def on_message_received(self, ch, method, properties, body):
        print(f"Received new message: {body}")
        # Assuming body contains email details, parse it and send the email
        EmailSender.send_email(body)

    def start_consuming(self):
        print("Starting consumer")
        self.channel.start_consuming()

class EmailSender:
    @staticmethod
    def send_email(body):
        decodeMessage = json.loads(body)
        sender = "lq1930@gmail.com"
        password = "wben rxok npkx qrgv"
        email = decodeMessage["email"]
        message = decodeMessage["message"]
        subject = decodeMessage["subject"]
        recipients = ["lq1930@gmail.com"]
        msg = MIMEText(message)
        msg['Subject'] = subject
        msg['From'] = email
        msg['To'] = ', '.join(recipients)
        with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp_server:
            smtp_server.login(sender, password)
            smtp_server.sendmail(email, recipients, msg.as_string())
        print("Message sent!")

if __name__ == "__main__":
    consumer = MessageConsumer()
    consumer.start_consuming()