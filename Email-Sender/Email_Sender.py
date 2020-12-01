import os
import smtplib

userid = os.environ.get('Gmail_Python_User')
password = os.environ.get('Gmail_Python_Password')

#with smtplib.SMTP('smtp.gmail.com', 587) as smtp:
with smtplib.SMTP('localhost', 1025) as smtp:

    # smtp.ehlo()
    # smtp.starttls()
    # smtp.ehlo()

    #smtp.login(userid, password)

    subject = 'Foo' #enter subject of email
    body = 'Bar'    #enter body of email

    msg = f'Subject:{subject}\n\n{body}'
   # smtp.sendmail(userid, '<enter email of adressee>', msg)

    

