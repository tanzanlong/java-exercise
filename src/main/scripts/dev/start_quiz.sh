#!/bin/sh
#变量设置
SERVICE_NAME=discrepancy-money-service
PROJECT_DIR=$(cd "$(dirname "$0")"; pwd)
mkdir -p /logs/$SERVICE_NAME
PROJECT_DIR=$PROJECT_DIR/..
CONFIG_DIR=$PROJECT_DIR/config
LIB_DIR=$PROJECT_DIR/lib
LIB_JARS=`ls $LIB_DIR | grep .jar | awk '{print "'$LIB_DIR'/"$0}' | tr "\n" ":"`
MAIN_CLASS="com.baibei.wine.paycenter.Bootstrap"
# 设置classpath
#nohup java -classpath $CONFIG_DIR:$LIB_JARS $MAIN_CLASS &
#nohup java -Xms1024M -Xmx2048M -Xmn1536M -Xss512k -Denv=dev -Ddev_meta=http://120.77.180.207:8080 -Dapollo.cluster=quiz -classpath $CONFIG_DIR:$LIB_JARS $MAIN_CLASS >> /logs/$SERVICE_NAME/std-out.log 2>&1 &

java -Xms1024M -Xmx2048M -Xmn1536M -Xss512k -Denv=dev -Ddev_meta=http://172.18.182.160:8080 -classpath $CONFIG_DIR:$LIB_JARS $MAIN_CLASS | tee -a /logs/$SERVICE_NAME/std_out.log