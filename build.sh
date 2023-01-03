#!/bin/bash
VERSION=0.0.6-SNAPSHOT
docker build -t szymon2kozlowski/workload-manager:$VERSION .
docker push szymon2kozlowski/workload-manager:$VERSION