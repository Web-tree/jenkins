#!/usr/bin/env bash
helm install -n jenkins stable/jenkins -f values.yaml --namespace=infrastructure