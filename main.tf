terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.33.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
}

resource "aws_s3_bucket" "catalog-bucket" {
  bucket = "bucket-catalog-json"
  tags = {
    Name        = "catalog-bucket"
    Environment = "dev"
  }
  force_destroy = true
}

resource "aws_sqs_queue" "catalog-emit-queue" {
  name = "catalog-queue"
  max_message_size          = 2048
  message_retention_seconds = 180
  tags = {
    Environment = "dev"
  }
}