--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4
-- Dumped by pg_dump version 15.4

-- Started on 2023-10-28 15:05:08 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3357 (class 0 OID 16407)
-- Dependencies: 216
-- Data for Name: ingredients; Type: TABLE DATA; Schema: product_catalog; Owner: -
--

INSERT INTO product_catalog.ingredients VALUES (10.2, 0, '2023-10-28 13:14:03.357761+00', '2023-10-28 13:14:03.357761+00', '9aa9f551-6631-4d67-baac-60703e6124e1', 'Coke syrup', 'G');
INSERT INTO product_catalog.ingredients VALUES (0.005, 0, '2023-10-28 13:13:19.062272+00', '2023-10-28 13:13:19.062272+00', '2cefb6e2-38a3-471f-89f5-d815908d847e', 'Flour', 'G');
INSERT INTO product_catalog.ingredients VALUES (0.002, 0, '2023-10-28 13:13:22.704111+00', '2023-10-28 13:13:22.704111+00', 'b09bf028-a8f2-47fb-bd76-d95d3ba184c3', 'Salt', 'G');
INSERT INTO product_catalog.ingredients VALUES (0.003, 0, '2023-10-28 13:13:25.447295+00', '2023-10-28 13:13:25.447295+00', '8227c357-1878-4bbf-998b-85e8caf44e29', 'Baking soda', 'G');
INSERT INTO product_catalog.ingredients VALUES (0.0053, 0, '2023-10-28 13:13:28.922555+00', '2023-10-28 13:13:28.922555+00', '46253479-58a7-4890-a57e-d9ab63055406', 'Basmati Rice ', 'G');
INSERT INTO product_catalog.ingredients VALUES (0.001, 0, '2023-10-28 13:13:12.528982+00', '2023-10-28 13:13:12.528982+00', 'e64fef92-e845-461c-8213-8bf28d4b3f3e', 'Water', 'L');


--
-- TOC entry 3358 (class 0 OID 16415)
-- Dependencies: 217
-- Data for Name: products; Type: TABLE DATA; Schema: product_catalog; Owner: -
--

INSERT INTO product_catalog.products VALUES (0.3, 0, '2023-10-28 15:02:54.216381+00', '2023-10-28 15:02:54.216381+00', '1810c3e6-d6fa-4c8a-bec2-982b7eed7b7e', 'Coca-Cola', 'BEVERAGE', 'L');
INSERT INTO product_catalog.products VALUES (200, 0, '2023-10-28 15:02:57.899945+00', '2023-10-28 15:02:57.899945+00', '06ff3d6f-0a4b-46e8-a847-cf051cbaae93', 'Basmati Rice', 'FOOD', 'G');
INSERT INTO product_catalog.products VALUES (150, 0, '2023-10-28 15:03:00.971428+00', '2023-10-28 15:03:00.971428+00', '485a7291-09f7-401e-a927-0ef66bb78816', 'Basic Cake', 'DESERT', 'G');


--
-- TOC entry 3359 (class 0 OID 16424)
-- Dependencies: 218
-- Data for Name: product_ingredients; Type: TABLE DATA; Schema: product_catalog; Owner: -
--

INSERT INTO product_catalog.product_ingredients VALUES (150, 0, '2023-10-28 15:02:54.227358+00', '2023-10-28 15:02:54.227358+00', 'e0feae0e-0130-48f5-b9f8-241c3d4c4b72', '9aa9f551-6631-4d67-baac-60703e6124e1', '1810c3e6-d6fa-4c8a-bec2-982b7eed7b7e');
INSERT INTO product_catalog.product_ingredients VALUES (1, 0, '2023-10-28 15:02:54.228563+00', '2023-10-28 15:02:54.228563+00', '49ff1976-d8cd-45e7-96f7-ad1fb41ead2d', 'e64fef92-e845-461c-8213-8bf28d4b3f3e', '1810c3e6-d6fa-4c8a-bec2-982b7eed7b7e');
INSERT INTO product_catalog.product_ingredients VALUES (200, 0, '2023-10-28 15:02:57.900275+00', '2023-10-28 15:02:57.900275+00', '4ff4789a-5eb8-4b5e-a492-4805a170a2da', '46253479-58a7-4890-a57e-d9ab63055406', '06ff3d6f-0a4b-46e8-a847-cf051cbaae93');
INSERT INTO product_catalog.product_ingredients VALUES (3, 0, '2023-10-28 15:02:57.900422+00', '2023-10-28 15:02:57.900422+00', '5f5c6b43-36c2-4077-826f-62483870489d', 'b09bf028-a8f2-47fb-bd76-d95d3ba184c3', '06ff3d6f-0a4b-46e8-a847-cf051cbaae93');
INSERT INTO product_catalog.product_ingredients VALUES (2, 0, '2023-10-28 15:03:00.972099+00', '2023-10-28 15:03:00.972099+00', '0e97f07c-3eaf-467f-b8cd-07f2f687769b', 'b09bf028-a8f2-47fb-bd76-d95d3ba184c3', '485a7291-09f7-401e-a927-0ef66bb78816');
INSERT INTO product_catalog.product_ingredients VALUES (10, 0, '2023-10-28 15:03:00.97248+00', '2023-10-28 15:03:00.97248+00', '51e6ec8b-e94a-40bc-921b-c2a01dde107d', '8227c357-1878-4bbf-998b-85e8caf44e29', '485a7291-09f7-401e-a927-0ef66bb78816');
INSERT INTO product_catalog.product_ingredients VALUES (500, 0, '2023-10-28 15:03:00.973357+00', '2023-10-28 15:03:00.973357+00', '3f1e35ef-87c1-4bb6-a885-c141f283c9ee', '2cefb6e2-38a3-471f-89f5-d815908d847e', '485a7291-09f7-401e-a927-0ef66bb78816');


-- Completed on 2023-10-28 15:05:08 UTC

--
-- PostgreSQL database dump complete
--

