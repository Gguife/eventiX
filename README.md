<h1 align="center" style="font-weight: bold;">Event register System 💻</h1>

<p align="center">
 <a href="#technologies">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Collaborators</a>
</p>

<p align="center">
    <b>The application manages events, allowing registration, listing, filtering, viewing event details, and associating discount coupons.</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

- Java
- Spring Boot
- Postgresql
- Docker

<h2 id="started">🚀 Getting started</h2>

Here is a step-by-step guide to run your project locally.

<h3>Prerequisites</h3>

Make sure you have the following software installed on your system:

- [java JDK 22]([https://nodejs.org/en](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html))
- [Postgresql](https://www.postgresql.org/download/)

<h3>Cloning</h3>

```bash
git clone https://github.com/Gguife/system_auth
```

<h2 id="routes">📍 API Endpoints</h2>

## Event

| Route                           | Model          | Description                                      |
|---------------------------------|-----------------|--------------------------------------------------|
| <kbd>GET /api/event</kbd>       | <strong>Event</strong>   | Get a list of upcoming events                    |
| <kbd>POST /api/event</kbd>      | <strong>Event</strong>   | Create a new event                               |
| <kbd>GET /api/event/{eventId}</kbd> | <strong>Event</strong>   | Get details of a specific event                  |
| <kbd>GET /api/event/filter</kbd>  | <strong>Event</strong>   | Get filtered events based on criteria            |

## Coupon

| Route                           | Model          | Description                                      |
|---------------------------------|-----------------|--------------------------------------------------|
| <kbd>POST /api/coupon/event/{eventId}</kbd> | <strong>Coupon</strong> | Add a coupon to a specific event                 |



<h2 id="colab">🤝 Collaborators</h2>


  <a href="https://www.linkedin.com/in/gguife/"> Guilherme Gomes</a>
