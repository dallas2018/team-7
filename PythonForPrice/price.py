import requests
import urllib2
import json

key = "p8neybarau93myeddfzwx5pu"

url = "http://api.walmartlabs.com/v1/items?apiKey=" + key + "&upc= item_code"

data = json.load(urllib2.urlopen(url))

print data
