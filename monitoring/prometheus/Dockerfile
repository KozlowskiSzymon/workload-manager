FROM prom/prometheus:v2.38.0
COPY prometheus.yaml /etc/prometheus/
EXPOSE 9090
CMD ["--config.file=/etc/prometheus/prometheus.yaml"]