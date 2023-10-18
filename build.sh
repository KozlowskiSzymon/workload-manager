#!/bin/bash
VERSION=0.2.4
docker build -t szymon2kozlowski/workload-manager:$VERSION .
docker push szymon2kozlowski/workload-manager:$VERSION