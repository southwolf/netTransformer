export HTTP_PORT=8080
export SHUTDOWN_PORT=$(($HTTP_PORT+1))
export HTTPS_PORT=$(($HTTP_PORT+2))
export AJP_PORT=$(($HTTP_PORT+3))
export JMX_PORT=$(($HTTP_PORT+4))
export JPDA_PORT=$(($HTTP_PORT+5))
