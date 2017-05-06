import cPickle as pickle
import sys
from springcloudstream.stream import Processor, Encoders


class Page:
    def __init__(self, data):
        self.links = data['links']
        self.images = data['images']


# protocol = pickle.HIGHEST_PROTOCOL
protocol = 1


def unpickle(data):
    try:
        data = pickle.loads(data)
        return pickle.dumps(Page(data).__dict__, protocol)
    except:
        return "unpickle failed [%s] [%s] [%s]" % (sys.exc_info()[0], sys.exc_info()[1], sys.exc_info()[2])


process = Processor(Encoders.BINARY)
process.start(unpickle)