# magnetoml
ml tec
url: https://magnetoapi.herokuapp.com/hello [GET] br />
url: https://magnetoapi.herokuapp.com/mutant [POST]


MQTT.js is a client library for the [MQTT](http://mqtt.org/) protocol, written
in JavaScript for node.js and the browser.

* [Upgrade notes](#notes)
* [Installation](#install)
* [Example](#example)
* [Command Line Tools](#cli)
* [API](#api)
* [Browser](#browser)
* [Weapp](#weapp)
* [About QoS](#qos)
* [TypeScript](#typescript)
* [Contributing](#contributing)
* [License](#license)

MQTT.js is an OPEN Open Source Project, see the [Contributing](#contributing) section to find out what this means.

[![JavaScript Style
Guide](https://cdn.rawgit.com/feross/standard/master/badge.svg)](https://github.com/feross/standard)


<a name="notes"></a>
## Important notes for existing users

v2.0.0 removes support for node v0.8, v0.10 and v0.12, and it is 3x faster in sending
packets. It also removes all the deprecated functionality in v1.0.0,
mainly `mqtt.createConnection` and `mqtt.Server`. From v2.0.0,
subscriptions are restored upon reconnection if `clean: true`.
v1.x.x is now in *LTS*, and it will keep being supported as long as
there are v0.8, v0.10 and v0.12 users.

v1.0.0 improves the overall architecture of the project, which is now
split into three components: MQTT.js keeps the Client,
[mqtt-connection](http://npm.im/mqtt-connection) includes the barebone
Connection code for server-side usage, and [mqtt-packet](http://npm.im/mqtt-packet)
includes the protocol parser and generator. The new Client improves
performance by a 30% factor, embeds Websocket support
([MOWS](http://npm.im/mows) is now deprecated), and it has a better
support for QoS 1 and 2. The previous API is still supported but
deprecated, as such, it is not documented in this README.

As a __breaking change__, the `encoding` option in the old client is
removed, and now everything is UTF-8 with the exception of the
`password` in the CONNECT message and `payload` in the PUBLISH message,
which are `Buffer`.

Another __breaking change__ is that MQTT.js now defaults to MQTT v3.1.1,
so to support old brokers, please read the [client options doc](#client).

MQTT v5 support is experimental as it has not been implemented by brokers yet.

<a name="install"></a>
## Installation

```sh
npm install mqtt --save
```

<a name="example"></a>
## Example
