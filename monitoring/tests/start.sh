#!/bin/bash
echo 'sleeping 1...'
sleep 2
echo 'Starting tests...'

URL=$WORKLOAD_MANAGER_URL
START_PATH=$WORKLOAD_MANAGER_START_PATH
TASK_PATH=$WORKLOAD_MANAGER_TASK_PATH
SET=$TEST_SET

if [ ${SET}==1 ]; then
  echo 'Start initializing users'
  curl "${URL}${START_PATH}"
  echo 'Finish initializing users'
fi

if [ ${SET}==2 ]; then
  echo 'Start creating tasks for users'
  for IT in 1 .. 4
  do
    for USER_ID in 1 .. 100
    do
      curl -X POST "${URL}/${USER_ID}${TASK_PATH}"
    done
    echo 'Finish creating tasks for users'
  done
fi
