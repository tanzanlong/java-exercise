#!/bin/sh
#变量设置
SERVICE_NAME=discrepancy-money-service
PROJECT_DIR=$(cd "$(dirname "$0")"; pwd)
PROJECT_DIR=$PROJECT_DIR/..
CONFIG_DIR=$PROJECT_DIR/config
LIB_DIR=$PROJECT_DIR/lib
LIB_JARS=`ls $LIB_DIR | grep .jar | awk '{print "'$LIB_DIR'/"$0}' | tr "\n" ":"`
MAIN_CLASS="com.baibei.wine.paycenter.Bootstrap"
# 设置classpath
#nohup java -classpath $CONFIG_DIR:$LIB_JARS $MAIN_CLASS &
#nohup java -Dspring.profiles.active=cbec -classpath $CONFIG_DIR:$LIB_JARS $MAIN_CLASS

java -Xms512M -Xmx512M -Xmn256M -Xss512k -Denv=fat  -Dfat_meta=http://192.168.12.150:1666 -Dapollo.cluster=uat-bwb -Dyop.sdk.config.file=file://data/cert/yop_sdk_config_default.json -classpath $CONFIG_DIR:$LIB_JARS $MAIN_CLASS | tee -a /logs/$SERVICE_NAME/std_out.log