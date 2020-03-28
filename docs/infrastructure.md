# Infrastructure Overview

## Cloud Formation
The infrastructure is managed by cloudfront. Currently changes to infrastructure require a manuall build and call of the provided dockerfile using the following commands.

```bash
docker build -t rhythm-ninja-capo-optimizer-lambda-infrastructure -f .docker/infrastructure/dockerfile .
docker run -v ~/.aws:/root/.aws rhythm-ninja-capo-optimizer-lambda-infrastructure
```
