import requests
from bs4 import BeautifulSoup
import smtplib
import time

URL = 'https://www.amazon.ca/Hisense-Smart-55H7709-Canada-Version/dp/B07X23MQ4X?ref_=ast_sto_dp'

headers = {
    "User-Agent": 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0'}

#Effects: Parse price on Amazon link
def check_price():
    page = requests.get(URL, headers=headers)
    soup = BeautifulSoup(page.content, 'html.parser')
    title = soup.find(id="productTitle").get_text()
    price = soup.find(id="priceblock_ourprice").get_text()
    
    #float(price[4:8]) is ok for Amazon Canada three digit prices. Modify accordingly for your use
    converted_price = float(price[4:8])
    print(title.strip())
    print(price.strip())
    if(converted_price <= 394.00):
        send_mail()

#Requires: Email address and server SMPT for sending email, receiver's address
#Effects: Send an email message
        
def send_mail():
    try:
        #Change the SMTP server settings according to the email server (below settings are good for gmail)
        server = smtplib.SMTP('smtp.gmail.com', 587)
        server.ehlo()
        server.starttls()
        server.ehlo()
        #First value will be the email address that will be used to send the email, second value is the password for that email
        server.login('abcd@xyz.com', '745765gdg')

        subject = 'Price fell down!'
        body = 'Check the amazon link https://www.amazon.ca/Hisense-Smart-55H7709-Canada-Version/dp/B07X23MQ4X?ref_=ast_sto_dp'
        msg = f"Subject: {subject}\n\n{body}"
        #change the email address to reciever's address
        server.sendmail(
            'asd1234@asd123.com',
            'asgsadf2@hfhhsd.com',
            msg
        )
        print('Email has been sent!')
        server.quit()
    except:
        print('Failed to send email')

#This loop will make it to run once a day. 
while(True):
    check_price()
    time.sleep(60*60*24)
