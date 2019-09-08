import os
import requests
import re

from flask import Flask

app = Flask(__name__)


def get_local_ip():
    """
    @ 如果已经有本地ip的文件，直接读文件，如果没有，请求接口获取，并保存到ip文件中
    :return:
    """
    path = os.path.split(os.path.realpath(__file__))[0] + '/tmp/'
    if os.path.exists(path + 'local_ip.txt'):  # 有本地ip文件
        with open(path + 'local_ip.txt', 'r') as handler:
            ip = handler.read()
    else:  # 没有本地ip文件
        if not os.path.exists(path):
            os.mkdir(path)
        try:
            res = requests.get('http://pv.sohu.com/cityjson?ie=utf-8', headers={
                'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36'},
                               timeout=2).text
            ip = re.search('"cip": "(.*?)"', res).group(1)
            with open(path + 'local_ip.txt', 'w') as handler:
                handler.write(ip)
        except Exception as e:
            print('error', e)
            ip = 'UNKNOWN'
    return ip


@app.route('/test')
def hello_world():
    return get_local_ip()


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8081)
