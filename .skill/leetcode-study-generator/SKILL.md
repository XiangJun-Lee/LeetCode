---
name: leetcode-study-generator
description: Use when the user invokes a LeetCode study command, provides a LeetCode link, asks to initialize a LeetCode study workspace, generate a problem study folder, or strengthen practice by knowledge point.
---

# LeetCode Study Generator

## Purpose

Create and maintain a consistent LeetCode study workspace. The skill supports three command workflows:

1. `/leetcode-study-generator init`
2. `/leetcode-study-generator <leetcode-url>`
3. `/leetcode-study-generator knowledge-point <knowledge point> [num]`

Every generated problem gets a study `index.html`, a hint-free practice code file, runnable tests, and an entry in the yearly `leetcode-problem-bank.html` page.

Never assume the project directory, study directory, or practice language. Resolve missing inputs before writing files.

## Change Handling

When the user changes any generation rule, treat it as a workflow design change, not as an isolated patch.

Before editing generated files or this skill:
1. Re-read the affected workflow sections end to end.
2. Update all dependent rules together: command parsing, directory naming, HTML structure, code files, tests, commands, verification, and problem-bank indexing.
3. Remove or rewrite outdated wording that conflicts with the new rule.
4. Keep examples, file names, and commands aligned with the current rule set.

## Command Contract

### `/leetcode-study-generator init`

Initialize the project structure for LeetCode study.

Execution:
1. Ask for the engineering/project directory when it is not already known.
2. Inspect the project shallowly with `find <dir> -maxdepth 3 -type f` and `rg --files <dir>`.
3. Infer the common practice language from project signals:
   - Java: `pom.xml`, `build.gradle`, `.iml`, `src/main/java`, `src/com`, many `.java` files.
   - Python/Python3: `pyproject.toml`, `requirements.txt`, many `.py` files.
   - JavaScript/TypeScript: `package.json`, `tsconfig.json`, many `.js`, `.jsx`, `.ts`, or `.tsx` files.
   - Go: `go.mod`, many `.go` files.
   - C/C++: `CMakeLists.txt`, many `.c`, `.cc`, `.cpp`, `.h`, or `.hpp` files.
   - Rust: `Cargo.toml`, many `.rs` files.
4. If language signals conflict or are weak, ask the user for the common LeetCode practice language.
5. Suggest a study directory based on the detected language and allow the user to accept or specify another directory.
6. Create the study directory if needed.
7. Create or update `leetcode-problem-bank.html` in the study directory.
8. Remember for the current task: project directory, study directory, common language, and source root if the language uses packages.

Recommended study directories:
- Java with `src/com`: `src/com/leetcodeYYYY`.
- Java with `src/main/java`: `src/main/java/leetcodeYYYY`.
- Python/Python3: `leetcode/YYYY`.
- JavaScript/TypeScript: `leetcode/YYYY`.
- Go: `leetcode/YYYY` unless the module has an established examples/practice layout.
- C++: `leetcode/YYYY`.

Use the current year unless the user specifies another year. Do not write outside the approved project/study directory.

### `/leetcode-study-generator <leetcode-url>`

Initialize one LeetCode problem.

Execution:
1. If the workspace is not initialized, run the `init` workflow first.
2. Extract the problem slug from the URL.
3. Browse or otherwise verify the problem number, localized title, examples, constraints, tags, and official solution availability.
4. Open the official solution when it exists. If the page does not expose it, search the slug plus `官方题解` or `LeetCode official solution`.
5. If no official solution is available, use a high-quality accepted editorial or standard optimal approach and state that it is not official.
6. Generate or update the problem folder using the shared generation rules below.
7. Update `leetcode-problem-bank.html`.
8. Run verification and clean generated artifacts.

The generated explanation, reference implementation, tests, and complexity must not be worse than the official answer in correctness, edge cases, or asymptotic complexity.

### `/leetcode-study-generator knowledge-point <knowledge point> [num]`

Strengthen practice for one knowledge point.

Parsing:
- Treat the final token as `num` only when it is a positive integer.
- If `num` is omitted, use `1`.
- Treat every token between `knowledge-point` and the optional final `num` as the knowledge point, so multi-word topics such as `binary search answer` work.

Selection:
1. If the workspace is not initialized, run the `init` workflow first.
2. Build the LeetCode China search URL `https://leetcode.cn/search/?q=<url-encoded knowledge point>` and use it as the first lookup source.
3. Browse current LeetCode and reliable curated sources to identify high-frequency problems for the knowledge point.
4. Prefer LeetCode China search results, LeetCode China topic/tag pages, official lists such as 热题 100 or 面试经典, and widely accepted curated lists when official frequency data is not exposed.
5. Rank candidates by frequency signals: appearance across official/curated high-frequency lists, topic/tag match quality, search-result relevance, interview-list presence, and community consensus.
6. Prefer classic representative problems that directly exercise the requested knowledge point over loosely related problems.
7. Verify each candidate's problem number, title, slug, URL, tags, examples, constraints, and official solution availability.
8. A problem counts as completed when its problem directory exists in the study directory or it is indexed in `leetcode-problem-bank.html`.
9. Select up to `num` high-frequency uncompleted verified problems.
10. If fewer than `num` uncompleted problems are available, generate the available uncompleted problems and report the shortfall.
11. If zero uncompleted problems are available, present up to five completed matching problems sorted by frequency, or all completed matching problems when fewer than five exist, and ask the user whether to review one or more of them.

Generation:
- For selected uncompleted problems, run the same generation workflow as `/leetcode-study-generator <leetcode-url>` for each problem.
- Update `leetcode-problem-bank.html` once after all selected new problems are generated.
- Include a short source note in each generated `index.html` explaining why the problem was selected for the requested knowledge point.

Review reinitialization:
- If the user chooses completed problem(s) for review, preserve `index.html` and problem-bank content.
- Reinitialize only the practice code portion for the chosen existing folder(s): overwrite the practice code file with a hint-free skeleton and preserve or recreate runnable tests as needed.
- Do not regenerate or overwrite `index.html` unless the user explicitly asks for a full refresh.

## Shared Generation Rules

### Problem Directory

Use this directory name:

```text
<leetcode-slug-with-underscores>_<zero-padded-number>
```

Example:

```text
longest_substring_without_repeating_characters_003
```

For Java source/package trees, this directory name is a valid package segment; match the package statement to the directory path. Put all per-problem files in this directory. Do not leave standalone problem HTML files in the study directory root.

### `index.html`

Use one self-contained HTML file for every generated problem. Skip this step during review reinitialization unless the user explicitly requests a full refresh.

Required sections, in order:
1. Header with `LeetCode <number>：<Chinese title>` or the best localized title.
2. 题目概述.
3. 示例拆解.
4. 考察点.
5. 官方题解对比.
6. 解题思路.
7. 参考实现.
8. 核心变量/状态.
9. 执行过程可视化, when state changes are useful.
10. 易错点.
11. 复杂度分析.
12. 练习文件.
13. 来源链接.

Required style:
- One self-contained `<style>` block; no external CSS or CDN.
- Use CSS variables: `--bg`, `--panel`, `--ink`, `--muted`, `--line`, `--blue`, `--blue-soft`, `--green-soft`, `--orange-soft`.
- Body background `#f6f8fb`, white panels, 8px border radius, 1px borders.
- Header uses a blue-to-green linear gradient.
- Use `.wrap` with `width: min(1120px, calc(100% - 32px))`.
- Use full-width vertical sections, not nested cards or side-by-side decorative graph cards.
- Use responsive grids only for compact stat/example groups; collapse to one column on mobile.
- Keep fonts system-based: `-apple-system, BlinkMacSystemFont, "Segoe UI", "Microsoft YaHei", sans-serif`.

Content requirements:
- Problem number, title, source link, and concise restatement.
- Examples with output reasoning.
- Knowledge points and algorithm pattern.
- Official-solution comparison notes.
- Reasoning from brute force to optimized approach.
- Reference implementation in the initialized common language.
- Core variable/state explanation.
- Common mistakes and boundary cases.
- Time and space complexity.
- Practice file section with exact compile/test command.
- Link back to `../leetcode-problem-bank.html`.
- Problem source link and official solution link when available.
- In `knowledge-point` mode, explain why this problem was selected for that knowledge point.

Reference implementation comments:
- The reference implementation inside `index.html` is for learning and must be well commented in the initialized common language.
- For Java reference code, add enough comments to explain key variables, invariants, branch decisions, and update timing.
- Comments should teach the core logic without becoming line-by-line noise.
- This rule applies only to reference code inside `index.html`; practice files must remain hint-free.

Visualization:
- When the algorithm has evolving state, include a small plain HTML/CSS/JS visualization such as next-step and reset controls.

### Practice Code

Use the initialized common language.

General rules:
- Practice files must contain no hints, TODO comments, strategy notes, docstrings/Javadocs, or explanatory comments.
- Prefer a minimal stub that compiles/runs and fails tests clearly.
- Keep file names conventional for the selected language.
- During review reinitialization, overwrite only the practice code file(s) for the chosen existing problem(s), preserving `index.html`.

Language conventions:
- Java: `Solution.java` or fixed LeetCode class name such as `LRUCache.java`; legal package statement when under a source root; type-correct stub values.
- Python/Python3: `solution.py`; `class Solution:` with LeetCode-required method signature; Python 3 syntax; type hints when useful.
- Go: `solution.go`; `package main` for standalone folders unless project convention says otherwise; LeetCode-style function names.
- C++: `solution.cpp`; minimal standard headers; `class Solution` with public LeetCode method.
- JavaScript: `solution.js`; LeetCode-style function/class; export with `module.exports` so tests can import it.

### Runnable Tests

Use no external test framework unless the project already has one and the user wants it.

Test cases must include official examples, empty/minimal input, repeated values, and cases that catch common pointer, stale state, and boundary bugs.

Language-specific test files and commands:
- Java: `SolutionTest.java` or `<ClassName>Test.java`; use `main` and explicit assertions; run from the Java source root with `javac ... && java fully.qualified.TestClass`.
- Python/Python3: `test_solution.py`; use `unittest`; run `python3 test_solution.py`.
- Go: `solution_test.go`; use Go's `testing` package; run `go test`.
- C++: `solution_test.cpp`; use a small `main` with assertions; compile with `g++ -std=c++17 solution.cpp solution_test.cpp -o solution_test && ./solution_test`.
- JavaScript: `solution.test.js`; use Node's built-in `assert`; run `node solution.test.js`.

Include a short timeout guard when practical so loop bugs fail clearly instead of hanging.

During review reinitialization, preserve existing runnable tests when they already match the current problem signature. Recreate tests only when missing, broken, or inconsistent with the current language conventions.

### Exact Commands In HTML

The `index.html` practice section must show the exact command for the selected language:
- Java: run from source root, for example `javac com/leetcode2026/problem_name_000/Solution.java com/leetcode2026/problem_name_000/SolutionTest.java && java com.leetcode2026.problem_name_000.SolutionTest`.
- Python/Python3: `python3 test_solution.py`.
- Go: `go test`.
- C++: `g++ -std=c++17 solution.cpp solution_test.cpp -o solution_test && ./solution_test`.
- JavaScript: `node solution.test.js`.

Skip this step during review reinitialization because `index.html` must not be rewritten.

### `leetcode-problem-bank.html`

The page title and H1 must be `LeetCode 题库`.

The page must contain exactly these major content parts:
1. **进度**: total problems, covered 考察点 count, highest topic frequency, and total runnable test cases.
2. **考察点目录**: topics sorted by problem frequency descending; include topic name, frequency, and linked problem titles.
3. **考察点**: one vertical section per topic, with method overview/rule pattern and its own problem index.

Do not show an `更新规则` section. Do not use side-by-side graph cards. Preserve existing entries, recompute frequencies from all indexed problems, and use stable existing order for ties.

Skip problem-bank updates during review reinitialization unless the chosen problem is missing from the problem bank and the user explicitly asks to repair indexing.

## Verification And Cleanup

1. Run the language-appropriate compile/test command from the correct working directory.
2. If the practice file is intentionally a skeleton, the test run should fail clearly on an expected case; report that as expected.
3. If a completed implementation was requested, all tests must pass.
4. Remove generated build artifacts such as `.class`, C++ binaries, or temporary caches.
5. Verify HTML links and required sections, especially the link back to `leetcode-problem-bank.html`.
6. Compare the explanation, reference implementation, tests, and complexity against official solution notes before finishing.

## Safety Rules

- Preserve user edits in existing problem files; read before modifying.
- Update existing problem folders instead of creating duplicates.
- Keep edits scoped to the study directory and skill files.
- Do not commit unless the user asks.
- Do not leave temporary servers running.
