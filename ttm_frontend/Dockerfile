FROM python:3.12.4-slim-bullseye

WORKDIR /front

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

COPY . /front

RUN pip install --upgrade pip
RUN pip install -r requirements.txt