import argparse
import os
import time
import requests
import threading
import multiprocessing
import asyncio
from pathlib import Path

img_urls = ['https://masterstar.ru/news/img/484/2.jpg',
            'https://cdn-st4.rtr-vesti.ru/vh/pictures/hd/296/666/3.jpg',
            'https://mskgorod.ru/wp-content/uploads/2023/03/yandeks_brauzer_0.png',
            'https://www.osnmedia.ru/wp-content/uploads/2021/03/1515760522_201.jpg']

#img_path = 'images' не взлетело с относительными путями
img_path = 'C:\\Users\\Selishchev\\Desktop\\flask\\t4\\images\\'


def download_img(url):
    start_time = time.time()
    img_data = requests.get(url).content
    #filename = Path(img_path,os.path.basename(url))
    filename = img_path + str(os.path.basename(url))
    with open(filename, "wb") as f:
        f.write(img_data)
    end_time = time.time() - start_time
    print(f"{filename} за {end_time:.2f}")


async def download_img_async(url):
    start_time = time.time()
    response = await asyncio.get_event_loop().run_in_executor(None, requests.get, url, {"stream": True})
    img_data = response.content
    #filename = Path(img_path,os.path.basename(url))
    filename = img_path + str(os.path.basename(url))
    with open(filename, "wb") as f:
        f.write(img_data)
    end_time = time.time() - start_time
    print(f"{filename} за {end_time:.2f}")


def download_imgs_threading(urls):
    start_time = time.time()
    threads = []
    for url in urls:
        t = threading.Thread(target=download_img, args=(url,))
        t.start()
        threads.append(t)

    for t in threads:
        t.join()

    end_time = time.time() - start_time
    print(f"многопоточная скачка завершена за {end_time:.2f} ")


def download_imgs_multiprocessing(urls):
    start_time = time.time()
    processes = []
    for url in urls:
        p = multiprocessing.Process(target=download_img, args=(url,))
        p.start()
        processes.append(p)

    for p in processes:
        p.join()

    end_time = time.time() - start_time
    print(f"мнопроцессорная скачка завершена за {end_time:.2f} ")


async def download_imgs_asyncio(urls):
    start_time = time.time()
    tasks = []
    for url in urls:
        task = asyncio.ensure_future(download_img_async(url))
        tasks.append(task)
    await asyncio.gather(*tasks)

    end_time = time.time() - start_time
    print(f"асинхронная скачка завершена за {end_time:.2f} ")


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--url", action='append')
    args = parser.parse_args()

    urls = args
    if not args.url:
        urls = img_urls

    print('многопоточная')
    download_imgs_threading(urls)

    print('многопроцессорная')
    download_imgs_multiprocessing(urls)

    print('асинхронная')
    loop = asyncio.get_event_loop()
    loop.run_until_complete(download_imgs_asyncio(urls))