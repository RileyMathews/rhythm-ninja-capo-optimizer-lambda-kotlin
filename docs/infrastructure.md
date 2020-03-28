# Infrastructure Overview

## Cloud Formation
The infrastructure is managed by cloudfront. Currently changes to infrastructure require a manuall build and call of the provided dockerfile using the following commands. While automation of infrastructure change deployment is eventually desired, for now I will focus on best CI/CD practices of the code to the infrastructure.

```bash
docker build -t rhythm-ninja-capo-optimizer-lambda-infrastructure -f .docker/infrastructure/dockerfile .
docker run -v ~/.aws:/root/.aws rhythm-ninja-capo-optimizer-lambda-infrastructure
```
